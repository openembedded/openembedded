DESCRIPTION = "Tasks for a Network Attached Storage server"
LICENSE = "MIT"
PROVIDES = "task-nas-server-everything"
PR = "r2"

inherit task

PACKAGES = "\
	task-nas-server-everything \
	${NAS_SERVER_PACKAGES} \
"

NAS_SERVER_PACKAGES = "\
	task-nas-server-base \
	task-nas-server-samba \
	task-nas-server-dnsmasq \
	task-nas-server-iptables \
	task-nas-server-tzdata \
	task-nas-server-nfs \
	task-nas-server-vfat \
	task-nas-server-ntfs \
	task-nas-server-ext3 \
	task-nas-server-reiserfs \
"

RDEPENDS_task-nas-server-everything = "${NAS_SERVER_PACKAGES}"

DESCRIPTION_task-nas-server-base = "NAS-Server: Base Packages"
RDEPENDS_task-nas-server-base = "\
"
RRECOMMENDS_task-nas-server-base = "\
"

DESCRIPTION_task-nas-server-samba = "NAS-Server: Samba Server"
RDEPENDS_task-nas-server-samba = "\
	samba swat \
"
RRECOMMENDS_task-nas-server-samba = "\
"

DESCRIPTION_task-nas-server-dnsmasq = "NAS-Server: DNS/DHCP Server"
RDEPENDS_task-nas-server-dnsmasq = "\
	dnsmasq \
"
RRECOMMENDS_task-nas-server-dnsmasq = "\
"

DESCRIPTION_task-nas-server-iptables = "NAS-Server: Netfilter/Iptables Support"
RDEPENDS_task-nas-server-iptables = "\
	iptables \
"
RRECOMMENDS_task-nas-server-iptables = "\
	kernel-module-iptable-nat \
	kernel-module-iptable-mangle \
	kernel-module-ipt-masquerade \
"

DESCRIPTION_task-nas-server-tzdata = "NAS-Server: Timezone Support"
RDEPENDS_task-nas-server-tzdata = "\
	tzdata \
"
RRECOMMENDS_task-nas-server-tzdata = "\
"

DESCRIPTION_task-nas-server-nfs = "NAS-Server: NFS Server"
RDEPENDS_task-nas-server-nfs = "\
	nfs-utils portmap \
"
RRECOMMENDS_task-nas-server-nfs = "\
"

DESCRIPTION_task-nas-server-vfat = "NAS-Server: FAT Filesystem"
RDEPENDS_task-nas-server-vfat = "\
"
RRECOMMENDS_task-nas-server-vfat = "\
"

DESCRIPTION_task-nas-server-ntfs = "NAS-Server: NTFS Filesystem"
RDEPENDS_task-nas-server-ntfs = "\
"
RRECOMMENDS_task-nas-server-ntfs = "\
"

DESCRIPTION_task-nas-server-ext3 = "NAS-Server: EXT3 Filesystem"
RDEPENDS_task-nas-server-ext3 = "\
"
RRECOMMENDS_task-nas-server-ext3 = "\
"

DESCRIPTION_task-nas-server-reiserfs = "NAS-Server: ReiserFS Filesystem"
RDEPENDS_task-nas-server-reiserfs = "\
"
RRECOMMENDS_task-nas-server-reiserfs = "\
"
