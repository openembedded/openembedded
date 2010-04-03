require tzcode-native.inc

# Note that elsie.nci.nih.gov removes old versions when new is coming out
# Other tzcode/tzdata recipes use Gentoo mirrors, but that is unreliable
# wrt older versions too. If you find any stable tzdata/tzcode mirror, please
# fix this URLs
SRC_URI = " \
	ftp://elsie.nci.nih.gov/pub/tzcode${PV}.tar.gz;name=tzcode-${PV} \
	ftp://elsie.nci.nih.gov/pub/tzdata2010g.tar.gz;name=tzdata-2010g \
	"
SRC_URI[tzcode-2010f.md5sum] = "e530cc9bbdfd5e8c1eac21a68f4d5656"
SRC_URI[tzcode-2010f.sha256sum] = "651d866c91ada925b4ac9491e69ebd5c355c46b2c01dd1741b5e6a609d93eb1e"
SRC_URI[tzdata-2010g.md5sum] = "d0e8f560977470b0fc65b79b585cf5e4"
SRC_URI[tzdata-2010g.sha256sum] = "a069dbea2989613466f9f4adb6de381efb46aeb9ff89e03fabb23dcae2c4cd90"

PR = "${INC_PR}.1"
