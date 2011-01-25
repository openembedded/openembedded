require tzcode-native.inc

# Note that elsie.nci.nih.gov removes old versions when new is coming out
# So if this doesn't build for you because of missing source file, just
# bump it to the latest available version, removing old one
# Also, tzdata (and it is needed to build tzcode) version can differ from
# tzcode version, thus this variable

TZDATA_PV = "2011a"

PR = "${INC_PR}.0"

SRC_URI[tzcode-2011a.md5sum] = "001db5591974e6db7797a90cbdcbbadc"
SRC_URI[tzcode-2011a.sha256sum] = "65a82a9411f3c085bcd3a4f195709717d3efbca36d9f726afaa3d3155fa34c44"
SRC_URI[tzdata-2011a.md5sum] = "d60f168fb7307d8c1b926c7dc3a6c5c1"
SRC_URI[tzdata-2011a.sha256sum] = "782c691b4750bdefeb84063128db685a8b8f31dc2efb887ee841ae105bfa747b"
