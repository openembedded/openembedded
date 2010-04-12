require gnome-mplayer.inc

SRC_URI += "file://gnome-mplayer-svn.diff;patch=1;pnum=0 \
            file://default.patch;patch=1 \
"

PR = "${INC_PR}.0"

SRC_URI[gnomemplayer.md5sum] = "540630654db044198c435f32c04b1b53"
SRC_URI[gnomemplayer.sha256sum] = "b275bae3f75e95e5b4e8b7596a7a362ba0ff9e5028e715540e4215bc8781af60"
