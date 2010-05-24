require nspr-tools-native.inc

SRC_URI = "\
	http://ftp.mozilla.org/pub/mozilla.org/nspr/releases/v${PV}/src/nspr-${PV}.tar.gz;name=archive \
	file://30_config_64bits.dpatch;apply=yes \
	file://30_pkgconfig.dpatch;apply=yes \
	file://81_sonames.dpatch;apply=yes \
	file://99_configure.dpatch;apply=yes \
	file://unbreak-build.diff \
	"

SRC_URI[archive.md5sum] = "7c6e75a0867ce2b9ec62e399a908b5ac"
SRC_URI[archive.sha256sum] = "58782b11423359f2a247f0217aab6fe041f32984aac1f411da6d43bd34cfd0db"

