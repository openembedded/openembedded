# Tasks for IPv6 Mobility extensions, needs:
# CONFIG_IPV6_MIP6=y
# CONFIG_IPV6=y
# in the kernel .config

DESCRIPTION = "Mobile ipv6 extensions"
PR = "r1"

inherit task

RDEPENDS_${PN} = "mipv6"
RRECOMMENDS_${PN} = "kernel-module-ipv6 \
               kernel-module-mip6 \
              "

