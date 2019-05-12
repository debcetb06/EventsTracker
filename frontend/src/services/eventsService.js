import http from "./httpService";

const eventsApiEndpoint = "/api/v1/events";
const eventTypesApiEndpoint = "/api/v1/eventTypes";

export function getEvents(owner, repo, eventType) {
  return http.get(eventsApiEndpoint, {
    params: {
      owner: owner,
      repo: repo,
      eventType: eventType
    }
  });
}

export function getEventTypes() {
  return http.get(eventTypesApiEndpoint);
}
