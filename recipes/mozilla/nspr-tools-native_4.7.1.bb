require nspr-tools-native.inc

SRC_URI = "\
	http://ftp.mozilla.org/pub/mozilla.org/nspr/releases/v${PV}/src/nspr-${PV}.tar.gz;name=archive \
	file://30_config_64bits.dpatch;patch=1 \
	file://30_pkgconfig.dpatch;patch=1 \
	file://81_sonames.dpatch;patch=1 \
	file://99_configure.dpatch;patch=1 \
	file://unbreak-build.diff;patch=1 \
	"

SRC_URI[archive.md5sum] = "7c6e75a0867ce2b9ec62e399a908b5ac"
SRC_URI[archive.sha256sum] = "58782b11423359f2a247f0217aab6fe041f32984aac1f411da6d43bd34cfd0db"

