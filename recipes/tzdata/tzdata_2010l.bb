require tzdata.inc

# Note that elsie.nci.nih.gov removes old archives when new is being
# released. So if this doesn't build for you because of missing source file
# just bump it to the latest available version, removing old one

PR = "${INC_PR}.0"

SRC_URI[tar.md5sum] = "0458bd8ffd537146d34b1a658c42efa5"
SRC_URI[tar.sha256sum] = "bae7b4a8364f7ab3d6d644eb6075de1e9a0c72fb3fb5843fc217d2ff57408577"
