require tzcode-native.inc

# Note that elsie.nci.nih.gov removes old versions when new is coming out
# So if this doesn't build for you because of missing source file, just
# bump it to the latest available version, removing old one
# Also, tzdata (and it is needed to build tzcode) version can differ from
# tzcode version, thus this variable

TZDATA_PV = "2010l"

SRC_URI[tzcode-2010l.md5sum] = "77668c37a0b13753c65eee5db3a4b009"
SRC_URI[tzcode-2010l.sha256sum] = "489876779f75f1c7659d26c09c3bcce62188b60eeb3981e0e3cd1f7669808ccc"
SRC_URI[tzdata-2010l.md5sum] = "0458bd8ffd537146d34b1a658c42efa5"
SRC_URI[tzdata-2010l.sha256sum] = "bae7b4a8364f7ab3d6d644eb6075de1e9a0c72fb3fb5843fc217d2ff57408577"

PR = "${INC_PR}.0"
