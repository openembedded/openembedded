require opkg.inc

DEPENDS = "curl-sdk"
PR = "${INC_PR}"
target_libdir := "${libdir}"
inherit sdk

EXTRA_OECONF += "--with-opkglibdir=${target_libdir}"
