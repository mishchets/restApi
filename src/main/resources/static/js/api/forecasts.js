import Vue from 'vue'

const forecasts = Vue.resource('forecast/{id}')

export default {
    // ???get: forecasts.get(),???
    getById: id => forecasts.get({id}),
    getByPlaceId: placeId => forecasts.get({placeId}),
    getBySourceId: sourceId => forecasts.get({sourceId}),
    add: forecast => forecasts.save({}, forecast),
    update: forecast => forecasts.update({id: forecast.id}, forecast),
    remove: id => forecasts.remove({id}),
}