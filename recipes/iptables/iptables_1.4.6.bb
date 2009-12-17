require iptables.inc
PR = "${INC_PR}.0"

SRC_URI += "\
	file://netfilter_remove_ipt_DSCP.patch;patch=1 \
	"
