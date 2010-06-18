DESCRIPTION = "Systemd a init replacement"
HOMEPAGE = "http://www.freedesktop.org/wiki/Software/systemd"
LICENSE = "GPL"
DEPENDS = "readline udev dbus libcap2 libcgroup gtk+"
PRIORITY = "optional"
SECTION = "base/shell"

PV = "0.0"
PR_append = "+${SRCPV}"

inherit autotools vala

TAG = "1ebdf2d8793181f31b766b8342391aa1978f9917"

SRC_URI = "git://anongit.freedesktop.org/systemd;protocol=git;tag=${TAG} \
           file://execute.patch \
           file://systemadm.patch \
           file://disable_xml_generation.patch \
           file://replace_accpet4.patch \
           file://getty-serial@.service \
          "

S = "${WORKDIR}/git"

EXTRA_OECONF = " --with-distro=debian \
                 --with-rootdir=${base_prefix} \
               "

PACKAGES = "${PN} ${PN}-gui ${PN}-dbg ${PN}-doc"

FILES_${PN}-gui = "${bindir}/systemadm"

FILES_${PN} = " ${base_bindir}/* \
                ${datadir}/dbus-1/services \
                ${datadir}/dbus-1/system-services \
                ${datadir}/${PN} \
                ${sysconfdir} \
                ${base_libdir}/systemd/* \
                ${base_libdir}/systemd/system/* \
                ${base_libdir}/udev/rules.d \
                /cgroup \
                ${bindir}/systemd-install \
               "

FILES_${PN}-dbg += " /lib/systemd/.debug "

def get_baudrate(bb, d):
    return bb.data.getVar('SERIAL_CONSOLE', d, 1).split()[0]
    

def get_console(bb, d):
    return bb.data.getVar('SERIAL_CONSOLE', d, 1).split()[1]


do_install_append(){
        if [ ! ${@get_baudrate(bb, d)} = "" ]; then
          sed -i -e s/\@BAUDRATE\@/${@get_baudrate(bb, d)}/g ${WORKDIR}/getty-serial@.service
          install ${WORKDIR}/getty-serial@.service ${D}${base_libdir}/systemd/system/
          ln -sf ${base_libdir}/systemd/system/getty-serial@.service \
              ${D}${sysconfdir}/systemd/system/getty.target.wants/getty@${@get_console(bb, d)}.service
        fi
}
