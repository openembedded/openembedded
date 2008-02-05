require opkg_svn.bb

target_libdir := "${libdir}"

inherit native

EXTRA_OECONF += "--with-opkglibdir=${target_libdir}/opkg -disable-gpg"

