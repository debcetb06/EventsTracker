import React, { Component } from "react";

import { getEvents, getEventTypes } from "../services/eventsService";
import EventsTable from "../components/eventsTable";

class EventDetails extends Component {
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
  handleSubmit = async e => {
    e.preventDefault();
    const { owner, repo, eventType } = this.state.event;
    const { data: events } = await getEvents(owner, repo, eventType);
    console.log(events);
    this.setState({ events: events });
  };

  handleChange = e => {
    const event = { ...this.state.event };
    event[e.currentTarget.name] = e.currentTarget.value;
    this.setState({ event });
  };

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
