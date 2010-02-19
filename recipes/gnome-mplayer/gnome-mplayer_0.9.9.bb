require gnome-mplayer.inc

SRC_URI += "file://default.patch;patch=1 \
"

SRC_URI[gnomemplayer.md5sum] = "335918da07a62941778444e126ae5ede"
SRC_URI[gnomemplayer.sha256sum] = "8180f8de085879280be4a6356ae70acd749f37eea48c943870d3caa145d2826d"

PR = "${INC_PR}.0"
