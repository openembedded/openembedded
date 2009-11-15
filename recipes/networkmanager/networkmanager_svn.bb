require networkmanager-pre0.7.inc

SRCREV = "3202"

PV = "0.7+svnr${SRCPV}"
PR = "r1"

DEFAULT_PREFERENCE = "-1"

SRC_URI += "svn://svn.gnome.org/svn/NetworkManager/;module=trunk;proto=http \
            file://define_kernel_types_for_old_linux_headers.patch;patch=1 \
            file://no-restarts.diff;patch=1;pnum=0 \
           "

S = "${WORKDIR}/trunk"
