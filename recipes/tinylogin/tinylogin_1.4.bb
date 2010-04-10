DESCRIPTION = "TinyLogin is a suite of tiny UNIX \
utilities for handling logins, user authentication, \
changing passwords, and otherwise maintaining users \
and groups on an embedded system."
HOMEPAGE = "http://tinylogin.busybox.net/"
SECTION = "base"
LICENSE = "GPL"
PR = "r6"

#SRC_URI = "http://tinylogin.busybox.net/downloads/tinylogin-${PV}.tar.bz2 \
SRC_URI = "http://limpens.net/trac/at91-kit-trac/export/4/trunk/sources/tinylogin-${PV}.tar.bz2 \
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
    while read link; do case "$link" in /*/*/*) to="../../bin/tinylogin";; /bin/*) to="tinylogin";; /*/*) to="../bin/tinylogin";; esac; bn=`basename $link`; update-alternatives --install $link $bn $to 60; done <$D/etc/tinylogin.links
}


pkg_prerm_${PN} () {
    while read link
    do  
        case "$link" in
            /*/*/*) to="../../bin/tinylogin";;
            /bin/*) to="tinylogin";;
            /*/*) to="../bin/tinylogin";;
        esac
        bn=`basename $link`
        sh /usr/bin/update-alternatives --remove $bn $to
    done < /etc/tinylogin.links
}


SRC_URI[md5sum] = "44da0ff2b727455669890b24305e351d"
SRC_URI[sha256sum] = "5e542e4b7825305a3678bf73136c392feb0d44b8bbf926e8eda5453eea7ddd6b"
