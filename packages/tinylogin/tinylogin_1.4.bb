SECTION = "base"
DESCRIPTION = "TinyLogin is a suite of tiny UNIX \
utilities for handling logins, user authentication, \
changing passwords, and otherwise maintaining users \
and groups on an embedded system."
HOMEPAGE = "http://tinylogin.tinylogin.net/"
LICENSE = "GPL"
PR = "r5"

SRC_URI = "http://tinylogin.tinylogin.net/downloads/tinylogin-${PV}.tar.bz2 \
	file://cvs-20040608.patch;patch=1;pnum=1 \
	file://add-system.patch;patch=1;pnum=1 \
	file://adduser-empty_pwd.patch;patch=1 \
	file://remove-index.patch;patch=1"

EXTRA_OEMAKE = ""

do_compile () {
	oe_runmake 'CC=${CC}' 'CROSS=${HOST_PREFIX}'
}

do_install () {
	install -d ${D}${base_bindir}
	install -m 4755 tinylogin ${D}${base_bindir}/tinylogin
	install -d ${D}${sysconfdir}
	install -m 0644 tinylogin.links ${D}${sysconfdir}
}

pkg_postinst_${PN} () {
    # If we are not making an image we create links for the utilities that doesn't exist
    # so the update-alternatives script will get the utilities it needs
    # (update-alternatives have no problem replacing links later anyway)
    if test "x$D" = "x"; then while read link; do if test ! -h "$link"; then case "$link" in /*/*/*) to="../../bin/tinylogin";; /bin/*) to="tinylogin";; /*/*) to="../bin/tinylogin";; esac; ln -s $to $link; fi; done </etc/tinylogin.links; fi

    # This adds the links, remember that this has to work when building an image too, hence the $D
    while read link; do case "$link" in /*/*/*) to="../../bin/tinylogin";; /bin/*) to="tinylogin";; /*/*) to="../bin/tinylogin";; esac; bn=`basename $link`; update-alternatives --install $link $bn $to 40; done <$D/etc/tinylogin.links
}

