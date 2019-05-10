import React from 'react';
import axios from 'axios';
import NoteBox from "./NoteBox";

class DisplayNotes extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            notes: [],
            selected: ''
        }
    }

    componentDidMount() {
        axios.get('/notes').then((response) => {
            const newNotes = response.data.map(notes => {
                return {
                    title: notes.title,
                    content: notes.content
                };
            }).reverse()
            const newState = Object.assign({}, this.state, {
                notes: newNotes
            });
            this.setState(newState)
        })
            .catch(error => (error));
    }

    render() {
        return (
            <div className="notes">
                {this.state.notes.map((notes, index) => (
                    <NoteBox key={index} notes={notes}>
                    </NoteBox>
                ))}
            </div>
        )
    }
}

export default DisplayNotes