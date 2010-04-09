require tzdata.inc

# Note that elsie.nci.nih.gov removes old archives when new is being
# released. So if this doesn't build for you because of missing source file
# just bump it to the latest available version, removing old one

PR = "${INC_PR}.0"

SRC_URI[tar.md5sum] = "d384ac091e6d56802f9b3e6b3d3f0f2e"
SRC_URI[tar.sha256sum] = "a4918d60f63440ba9b6050205881e8a98d718dc0c2b7df5955f43e781eab6e7d"
