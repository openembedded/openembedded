# internal helper
def busybox_cfg(feature, features, tokens, cnf, rem):
	if type(tokens) == type(""):
		tokens = [tokens]
	rem.extend(['/^[# ]*' + token + '[ =]/d' for token in tokens])
	if type(features) == type([]) and feature in features:
		cnf.extend([token + '=y' for token in tokens])
	else:
		cnf.extend(['# ' + token + ' is not set' for token in tokens])
# Map distro and machine features to config settings
def features_to_busybox_settings(d):
	cnf, rem = ([], [])
	distro_features = bb.data.getVar('DISTRO_FEATURES', d).split()
	machine_features = bb.data.getVar('MACHINE_FEATURES', d).split()
	busybox_cfg('ipv6', distro_features, 'CONFIG_FEATURE_IPV6', cnf, rem)
	busybox_cfg('largefile', distro_features, 'CONFIG_LFS', cnf, rem)
	busybox_cfg('largefile', distro_features, 'CONFIG_FDISK_SUPPORT_LARGE_DISKS', cnf, rem)
	busybox_cfg('nls',  distro_features, 'CONFIG_LOCALE_SUPPORT', cnf, rem)
	busybox_cfg('ipv4', distro_features, 'CONFIG_FEATURE_IFUPDOWN_IPV4', cnf, rem)
	busybox_cfg('ipv6', distro_features, 'CONFIG_FEATURE_IFUPDOWN_IPV6', cnf, rem)
	busybox_cfg('kernel24', machine_features, 'CONFIG_FEATURE_2_4_MODULES', cnf, rem)
	return "\n".join(cnf), "\n".join(rem)
# X, Y = ${@features_to_uclibc_settings(d)}
# unfortunately doesn't seem to work with bitbake, workaround:
def features_to_busybox_conf(d):
	cnf, rem = features_to_busybox_settings(d)
	return cnf
def features_to_busybox_del(d):
	cnf, rem = features_to_busybox_settings(d)
	return rem
