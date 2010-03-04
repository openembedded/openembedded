DESCRIPTION = "Common CA certificates"
HOMEPAGE = "http://packages.debian.org/sid/ca-certificates"
SECTION = "misc"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "http://ftp.de.debian.org/debian/pool/main/c/ca-certificates/ca-certificates_${PV}.tar.gz;name=archive \
           file://remove-c-rehash.patch;patch=1"
SRC_URI[archive.md5sum] = "307052c985bec7f9a00eb84293eef779"
SRC_URI[archive.sha256sum] = "6924fafc35dd020da99bc86842f95f2a97a3a5ff084b0635eea815fe2777fc7c"

inherit autotools

do_install_prepend() {
        mkdir -p ${D}/usr/share/ca-certificates
        mkdir -p ${D}/usr/sbin
        mkdir -p ${D}/etc/ssl/certs
        mkdir -p ${D}/etc/ca-certificates/update.d
}

do_install_append() {
        cd ${D}/usr/share/ca-certificates
        echo "# Lines starting with # will be ignored" > ${D}/etc/ca-certificates.conf
        echo "# Lines starting with ! will remove certificate on next update" >> ${D}/etc/ca-certificates.conf
        echo "#" >> ${D}/etc/ca-certificates.conf
        for crt in $(find . -type f -name '*.crt' -print)
        do
                crt=$(echo $crt | sed -e 's/\.\///')
                echo $crt >> ${D}/etc/ca-certificates.conf
        done
}

PACKAGE_ARCH = "all"
PACKAGES = "${PN}"

pkg_postinst_${PN} () {
        /usr/sbin/update-ca-certificates
}

CONFFILES_${PN} = "/etc/ca-certificates.conf"
