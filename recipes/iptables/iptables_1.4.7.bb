require iptables.inc
inherit autotools
EXTRA_OECONF = "--with-kernel=${STAGING_INCDIR} \
                ${@base_contains('DISTRO_FEATURES', 'ipv6', '', '--disable-ipv6', d)}"

PR = "${INC_PR}.0"

SRC_URI[iptables-1.4.7.md5sum] = "645941dd1f9e0ec1f74c61918d70d52f"
SRC_URI[iptables-1.4.7.sha256sum] = "9f61f389cabdde79e26ca78c336db1b6373b67f80f7cfcb3e9d9ff520b325452"