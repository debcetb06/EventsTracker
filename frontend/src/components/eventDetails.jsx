import React, { Component } from "react";
import { getEvents, getEventTypes } from "../services/eventsService";
import EventsTable from "../components/eventsTable";
import Joi from "joi-browser";
import { toast } from "react-toastify";

class EventDetails extends Component {
  /*EventDetail component maintains the centralized state*/
  state = {
    eventTypes: [],
    events: [],
    event: {
      owner: "",
      repo: "",
      eventType: ""
    },
    errors: {}
  };

  /*Event Criteria Joi Schema validatiion */
  schema = {
    owner: Joi.string()
      .required()
      .label("Owner"),
    repo: Joi.string()
      .required()
      .label("Repo")
  };

  /*This method uses Joi validation framwork to validate the input filelds*/
  validate = () => {
    const options = {
      abortEarly: false,
      allowUnknown: true
    };
    const { error } = Joi.validate(this.state.event, this.schema, options);
    if (!error) return null;
    const errors = {};
    for (let item of error.details) errors[item.path[0]] = item.message;
    return errors;
  };

  /*This method will submit the form if there are no errors, and used Async and await to handle promise
    React Toast is used to dispaly the error as Toast message.
  */
  handleSubmit = async e => {
    e.preventDefault();
    const errors = this.validate();
    let events = { ...this.state.events };
    if (errors) {
      events = [];
      this.setState({ events: events });
    }
    this.setState({ errors: errors || {} });
    if (!errors) {
      try {
        const { owner, repo, eventType } = this.state.event;
        const { data: events } = await getEvents(owner, repo, eventType);
        this.setState({ events: events });
      } catch (ex) {
        if (ex.response && ex.response.status === 404) {
          toast.error("No events avaiable for selected Repo.");
        }
      }
    }
  };

  handleChange = e => {
    const event = { ...this.state.event };
    event[e.currentTarget.name] = e.currentTarget.value;
    this.setState({ event });
  };

  /* ComponentDidMount life cyscle is used to get eventTypes from backend and prepaulate event types drop down*/
  async componentDidMount() {
    const { data: eventTypes } = await getEventTypes();
    this.setState({ eventTypes: eventTypes });
  }

  render() {
    const { event, events, eventTypes } = this.state;

    return (
      <div>
        <h2>Event</h2>
        <form onSubmit={this.handleSubmit} className="pb-3">
          <div className="form-group">
            <label htmlFor="owner">Owner</label>
            <input
              value={event.owner}
              onChange={this.handleChange}
              id="owner"
              type="text"
              name="owner"
              className="form-control"
            />
            {this.state.errors.owner && (
              <div className="alert alert-danger">
                {this.state.errors.owner}
              </div>
            )}
          </div>
          <div className="form-group">
            <label htmlFor="repo">Repo</label>
            <input
              value={event.repo}
              onChange={this.handleChange}
              id="repo"
              type="text"
              name="repo"
              className="form-control"
            />
            {this.state.errors.repo && (
              <div className="alert alert-danger">{this.state.errors.repo}</div>
            )}
          </div>

          <div className="form-group">
            <label htmlFor="eventType">Event Type</label>
            <select
              name="eventType"
              id="eventType"
              className="form-control"
              onChange={this.handleChange}
            >
              <option value="" />
              {eventTypes.map(type => (
                <option key={type.id} value={type.eventType}>
                  {type.eventType}
                </option>
              ))}
            </select>
          </div>

          <button className="btn btn-primary">Search</button>
        </form>
        <EventsTable events={events} />
      </div>
    );
  }
}

export default EventDetails;
