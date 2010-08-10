require tzcode-native.inc

# Note that elsie.nci.nih.gov removes old versions when new is coming out
# So if this doesn't build for you because of missing source file, just
# bump it to the latest available version, removing old one
# Also, tzdata (and it is needed to build tzcode) version can differ from
# tzcode version, thus this variable

TZDATA_PV = "2010k"

SRC_URI[tzcode-2010k.md5sum] = "63cd2199679c91bed972a0248d6916af"
SRC_URI[tzcode-2010k.sha256sum] = "96671eac3a98d0c974833c8bfa7ea9b537cc9d32573e902103846b90f6dccdbd"
SRC_URI[tzdata-2010k.md5sum] = "5e2086249d6a6bb116534d358661ad3f"
SRC_URI[tzdata-2010k.sha256sum] = "ef69c99504c0fd9864ba8ef1daae5f2d4df097cf7dc350f09b8f70386272408d"

PR = "${INC_PR}.0"
