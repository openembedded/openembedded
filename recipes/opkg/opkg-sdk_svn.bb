require opkg.inc

DEPENDS = "curl-sdk"
PR = "r3"
target_libdir := "${libdir}"
inherit sdk

EXTRA_OECONF += "--with-opkglibdir=${target_libdir} --disable-gpg"
