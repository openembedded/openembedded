require tzdata.inc

# Note that elsie.nci.nih.gov removes old archives when new is being
# released. So if this doesn't build for you because of missing source file
# just bump it to the latest available version, removing old one

PR = "${INC_PR}.0"

SRC_URI[tar.md5sum] = "4d2a90afd5bffe8df97f3def245e178e"
SRC_URI[tar.sha256sum] = "bee0a26cca54db3413416d968c0a6361d83188b112d2512559d0e3602f254dc3"
