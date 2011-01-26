require tzdata.inc

# Note that elsie.nci.nih.gov removes old archives when new is being
# released. So if this doesn't build for you because of missing source file
# just bump it to the latest available version, removing old one

PR = "${INC_PR}.0"

SRC_URI[tar.md5sum] = "d60f168fb7307d8c1b926c7dc3a6c5c1"
SRC_URI[tar.sha256sum] = "782c691b4750bdefeb84063128db685a8b8f31dc2efb887ee841ae105bfa747b"

