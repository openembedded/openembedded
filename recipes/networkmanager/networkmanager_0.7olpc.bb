require networkmanager-pre0.7.inc

PR = "r2"
PV = "0.7olpc+git"

DEFAULT_PREFERENCE = "-1"

SRC_URI += "git://dev.laptop.org/users/sjoerd/NetworkManager.git;protocol=git;branch=olpc-patches;tag=f1fa6c27710196b7327402c59b2c55d920a12bb0 \
            file://define_kernel_types_for_old_linux_headers_and_warn_functions_from_glib_2_16.patch \
           "
S = "${WORKDIR}/git"
