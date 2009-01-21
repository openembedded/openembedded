#!/bin/sh
xrandr -o 3
pingus.bin --fast-mode -g 640x480 --disable-music --disable-sound --fullscreen
xrandr -o 0
