require tzdata.inc

# Note that elsie.nci.nih.gov removes old archives when new is being
# released. So if this doesn't build for you because of missing source file
# just bump it to the latest available version, removing old one

PR = "${INC_PR}.0"

SRC_URI[tar.md5sum] = "9e33cb126c8cb6673f39390d347fb0e2"
SRC_URI[tar.sha256sum] = "1454a13a32e23e81195404d00ab97a64a356e9a5852fc7d121ed7e58cbdb75aa"
