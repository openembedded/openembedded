require tzcode-native.inc

# Note that elsie.nci.nih.gov removes old versions when new is coming out
# Other tzcode/tzdata recipes use Gentoo mirrors, but that is unreliable
# wrt older versions too. If you find any stable tzdata/tzcode mirror, please
# fix this URLs
SRC_URI = " \
	ftp://elsie.nci.nih.gov/pub/tzcode${PV}.tar.gz;name=tzcode-${PV} \
	ftp://elsie.nci.nih.gov/pub/tzdata${PV}.tar.gz;name=tzdata-${PV} \
	"
SRC_URI[tzcode-2010f.md5sum] = "e530cc9bbdfd5e8c1eac21a68f4d5656"
SRC_URI[tzcode-2010f.sha256sum] = "651d866c91ada925b4ac9491e69ebd5c355c46b2c01dd1741b5e6a609d93eb1e"
SRC_URI[tzdata-2010f.md5sum] = "4a0e2a3594210fafc5c55b5247018618"
SRC_URI[tzdata-2010f.sha256sum] = "823361e38da3f79a34c0adb835b1b6d2ae640937e3f7a7f4a2181500eeff0e94"

PR = "${INC_PR}.0"
