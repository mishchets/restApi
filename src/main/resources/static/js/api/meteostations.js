import Vue from 'vue'

const meteostations = Vue.resource('meteostation/{id}')

export default {
    // getAll(),
    getById: id => meteostations.get({id}),
    getByPlaceId: placeId => meteostations.get({placeId}),
    add: meteostation => meteostations.save({}, meteostation),
    update: meteostation => meteostations.update({id: meteostation.id}, meteostation),
    remove: id => meteostations.remove({id}),
}