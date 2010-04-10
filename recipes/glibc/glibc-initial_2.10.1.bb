require glibc_${PV}.bb
require glibc-initial.inc

do_configure_prepend () {
	unset CFLAGS
}

SRC_URI[md5sum] = "ee71dedf724dc775e4efec9b823ed3be"
SRC_URI[sha256sum] = "cbad3e637eab613184405a87a2bf08a41991a0e512a3ced60d120effc73de667"
SRC_URI[md5sum] = "816b2d48a95ddc23b27fea03a1996443"
SRC_URI[sha256sum] = "b1f1ec9720036a3a33598b8478eef102535444a083d5b5813a6981ed74ab4071"
SRC_URI[md5sum] = "8ef88560ec608d5923ee05eb5f0e15ea"
SRC_URI[sha256sum] = "0fa72d1dd06a30642d3bb20a659f4ed0f4af54a205d7102896b68169b38676dc"
