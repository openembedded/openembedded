DESCRIPTION = "IPsec-Tools is a port of KAME's IPsec utilities to the \
Linux-2.6 IPsec implementation."
DEPENDS = "virtual/kernel openssl readline flex"
LICENSE = "BSD"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
SECTION = "console/net"

inherit autotools

#   --enable-adminport      enable admin port
#   --enable-gssapi         enable GSS-API authentication
#   --enable-hybrid         enable hybrid, both mode-cfg and xauth support
#   --enable-frag           enable IKE fragmentation payload support
#   --enable-stats          enable statistics logging function
#   --enable-dpd            enable dead peer detection
#   --enable-samode-unspec  enable to use unspecified a mode of SA
#   --disable-ipv6          disable ipv6 support
#   --enable-natt           enable NAT-Traversal (yes/no/kernel)
# 
#   --with-kernel-headers=/lib/modules/<uname>/build/include
#                           where your Linux Kernel headers are installed
#   --with-readline         support readline input (yes by default)
#   --with-openssl=DIR      specify OpenSSL directory
#   --with-libradius=DIR    specify libradius path (like/usr/pkg)
EXTRA_OECONF = "--with-kernel-headers=${STAGING_KERNEL_DIR} \
		--with-readline \
		--with-openssl=${STAGING_LIBDIR}/.. \
		--without-libradius \
		--without-gssapi"
PARALLEL_MAKE = ""
