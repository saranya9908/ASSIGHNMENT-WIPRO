import { Component } from '@angular/core';
import { NgFor, NgIf,NgClass } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';
interface Song {
  name: string;
  artist: string;
  album: string;
  duration: string; // e.g. "3:45"
  rating: number; // 1 to 5
  imageUrl: string;
}

@Component({
  selector: 'app-music-list',
  imports: [
    NgFor,
    NgIf,
    NgClass,
    FormsModule,
    MatCardModule,
    MatIconModule,
    MatSelectModule,
    MatButtonModule,
  ],
  templateUrl: './music-list.component.html',
  styleUrl: './music-list.component.css',
})
export class MusicListComponent {
  songs: Song[] = [
    {
      name: 'Shape of You',
      artist: 'Ed Sheeran',
      album: 'Divide',
      duration: '3:53',
      rating: 5,
      imageUrl: 'asserts/images/Shape_Of_You.png',
    },
    {
      name: 'Vachinde',
      artist: 'Madhu Priya, Ramky',
      album: 'Fidaa',
      duration: '4:10',
      rating: 4,
      imageUrl: 'asserts/images/Vachinde.jpg',
    },
    {
      name: 'Samajavaragamana',
      artist: 'Sid Sriram',
      album: 'Ala Vaikunthapurramuloo',
      duration: '4:30',
      rating: 5,
      imageUrl: 'asserts/images/Samajavaragamana.jpg',
    },
    {
      name: 'Srivalli',
      artist: 'Javed Ali',
      album: 'Pushpa',
      duration: '3:47',
      rating: 4,
      imageUrl: 'asserts/images/Srivalli.jpg',
    },
    {
      name: 'Inkem Inkem Inkem Kaavaale',
      artist: 'Sid Sriram',
      album: 'Geetha Govindam',
      duration: '4:35',
      rating: 5,
      imageUrl: 'asserts/images/Inkem.jpg',
    },
    // add more songs as needed
  ];

  selectedArtist = '';
  selectedAlbum = '';

  get artists(): string[] {
    return [...new Set(this.songs.map((s) => s.artist))].sort();
  }

  get albums(): string[] {
    return [...new Set(this.songs.map((s) => s.album))].sort();
  }

  get filteredSongs(): Song[] {
    return this.songs.filter((song) => {
      return (
        (this.selectedArtist ? song.artist === this.selectedArtist : true) &&
        (this.selectedAlbum ? song.album === this.selectedAlbum : true)
      );
    });
  }

  isTopRated(song: Song): boolean {
    return song.rating === 5;
  }
}
