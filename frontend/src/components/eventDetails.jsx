import React, { Component } from "react";

import { getEvents } from "../services/eventsService";

class EventDetails extends Component {
  state = {
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
    const events = await getEvents();
    this.setState({ events: events });
    console.log(events);
  };

  handleChange = e => {
    const event = { ...this.state.event };
    event[e.currentTarget.name] = e.currentTarget.value;
    this.setState({ event });
  };

  render() {
    const { event } = this.state;
    return (
      <div>
        <h2>Event</h2>
        <form onSubmit={this.handleSubmit}>
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
            <input
              value={event.eventType}
              onChange={this.handleChange}
              id="eventType"
              type="text"
              name="eventType"
              className="form-control"
            />
          </div>
          <button className="btn btn-primary">Search</button>
        </form>
      </div>
    );
  }
}

export default EventDetails;
