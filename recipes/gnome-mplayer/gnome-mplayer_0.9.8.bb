require gnome-mplayer.inc

SRC_URI += "file://gnome-mplayer-svn.diff;patch=1;pnum=0 \
            file://default.patch;patch=1 \
"

PR = "${INC_PR}.0"
