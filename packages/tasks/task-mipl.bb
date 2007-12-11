# Tasks for IPv6 Mobility extensions, needs:
# CONFIG_IPV6_MIP6=y
# CONFIG_IPV6=y
# in the kernel .config

DESCRIPTION = "Mobile ipv6 extensions"

inherit task

PACKAGE_ARCH = "all"

RDEPENDS = "mipv6"
RRECOMMENDS = "kernel-module-ipv6 \
               kernel-module-mip6 \
              "

