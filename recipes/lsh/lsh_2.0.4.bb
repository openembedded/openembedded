LICENSE = "GPL"
SECTION = "console/network"
DESCRIPTION = "lsh is a GNU GPL-licensed implementation of the SSH \
(version 2) protocol. It includes a server, a client, and some \
utility programs."
DEPENDS = "zlib gmp liboop"

SRC_URI = "http://www.lysator.liu.se/~nisse/archive/lsh-${PV}.tar.gz;name=src"
SRC_URI[src.md5sum] = "621f4442332bb772b92d397d17ccaf02"
SRC_URI[src.sha256sum] = "614b9d63e13ad3e162c82b6405d1f67713fc622a8bc11337e72949d613713091"
S = "${WORKDIR}/lsh-${PV}"

inherit autotools
configopts = "  --enable-debug-alloc    Enable memory allocation sanity checks \
		--enable-debug-trace    Enable tracing support \
		--enable-gcov           Instrument for gcov (requires a modern gcc) \
		--without-pty           Disable pty support \
		--disable-srp           Disable the (experimental) support for SRP \
		--disable-kerberos      Don't support kerberos \
		--disable-pam           Don't support PAM \
		--disable-datafellows-workarounds \
		--enable-initgroups-workaround \
		--disable-tcp-forward   Disable tcp forwarding \
		--disable-x11-forward   Disable x11 forwarding (proxy only) \
		--disable-agent-forward Disable auth-agent forwarding (proxy only) \
		--disable-ipv6          Disable IPv6 support \
		--disable-utmp          Disable utmp and wtmp support \
		--without-zlib          Don't use zlib compression \
		--with-tcpwrappers      Use tcp-wrappers for filtering connections \
		--with-sshd1=PROGRAM support fallback to SSH1 daemon \
		--with-scheme=PROGRAM Use a particular scheme implementation \
		--without-system-argp   Don't use the system's argp \
		--with-include-path     A colon-separated list of directories to search for \
		--with-lib-path         A colon-separated list of directories to search for \
		--with-x                use the X Window System"
EXTRA_OECONF = "--disable-srp --disable-kerberos --disable-pam \
		--without-x"
