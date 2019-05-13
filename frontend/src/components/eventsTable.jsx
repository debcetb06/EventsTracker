import React, { Component } from "react";

import Table from "./common/table";
import Avatar from "react-avatar";

class EventsTable extends Component {
  /*Any new column can be added as part of below columns[] and that will be displayed result grid automatically
   */
  columns = [
    { path: "id", label: "ID" },
    { path: "type", label: "Type" },
    { path: "repo.name", label: "Repo Name" },
    { path: "created_at", label: "Created Date" },
    { path: "actor.display_login", label: "Name" },
    {
      path: "actor.avatar_url",
      label: "Avatar",
      content: event => (
        <Avatar size="50" src={event.actor.avatar_url} round={true} />
      )
    }
  ];

  render() {
    const { events } = this.props;
    const totalCount = events.length;
    if (totalCount > 0) {
      return (
        <React.Fragment>
          <p>Showing {totalCount} events</p>
          <Table data={events} columns={this.columns} />
        </React.Fragment>
      );
    } else {
      return "";
    }
  }
}

export default EventsTable;
