require tzcode-native.inc

# Note that elsie.nci.nih.gov removes old versions when new is coming out
# Other tzcode/tzdata recipes use Gentoo mirrors, but that is unreliable
# wrt older versions too. If you find any stable tzdata/tzcode mirror, please
# fix this URLs
SRC_URI = " \
	ftp://elsie.nci.nih.gov/pub/tzcode${PV}.tar.gz;name=tzcode-${PV} \
	ftp://elsie.nci.nih.gov/pub/tzdata2010h.tar.gz;name=tzdata-2010h \
	"
SRC_URI[tzcode-2010f.md5sum] = "e530cc9bbdfd5e8c1eac21a68f4d5656"
SRC_URI[tzcode-2010f.sha256sum] = "651d866c91ada925b4ac9491e69ebd5c355c46b2c01dd1741b5e6a609d93eb1e"
SRC_URI[tzdata-2010h.md5sum] = "d384ac091e6d56802f9b3e6b3d3f0f2e"
SRC_URI[tzdata-2010h.sha256sum] = "a4918d60f63440ba9b6050205881e8a98d718dc0c2b7df5955f43e781eab6e7d"

PR = "${INC_PR}.2"
