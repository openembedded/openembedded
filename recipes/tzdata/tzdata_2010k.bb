require tzdata.inc

# Note that elsie.nci.nih.gov removes old archives when new is being
# released. So if this doesn't build for you because of missing source file
# just bump it to the latest available version, removing old one

PR = "${INC_PR}.0"

SRC_URI[tar.md5sum] = "5e2086249d6a6bb116534d358661ad3f"
SRC_URI[tar.sha256sum] = "ef69c99504c0fd9864ba8ef1daae5f2d4df097cf7dc350f09b8f70386272408d"
