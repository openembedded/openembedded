require gnome-mplayer.inc

SRC_URI += "file://default.patch;patch=1 \
"

SRC_URI[gnomemplayer.md5sum] = "79810913d245755b60c27d37e1d1f178"
SRC_URI[gnomemplayer.sha256sum] = "695a54c00db5d0a0f596eb1a10a58ad32a44e8d6c7585d7c86e0d75cef0a48b4"

PR = "${INC_PR}.0"
