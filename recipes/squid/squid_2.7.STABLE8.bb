PR = "${INC_PR}.0"
SQUID_MAJOR = "2.7"

include squid.inc

# GPLv2+ since 2.6.STABLE18
LICENSE = "GPL"

EXTRA_OECONF += "--enable-epoll"

SRC_URI[squid-2.7.STABLE8.md5sum] = "c061ba1c9ae39d0aaa8eca137f7dd18b"
SRC_URI[squid-2.7.STABLE8.sha256sum] = "9409b02fc53518e334395df803a1ae30f4ed385b0f041fb310b4c75e2a49138c"

do_configure_prepend() {
	export ac_cv_epoll_ctl=yes
}