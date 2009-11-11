DESCRIPTION = "a call recording application"
HOMEPAGE = "none"
SECTION = "system/applications"
LICENSE = "GPLv3 or later"
SRCNAME = "callrec"
DEPENDS = "gtk+"
RDEPENDS += "alsa-utils-alsactl alsa-utils-aplay"
PV = "0.2.4+svnr${SRCPV}"
PR = "r0"

S = "${WORKDIR}/trunk"
inherit autotools 

SRC_URI = "svn://svn.projects.openmoko.org/svnroot/callrec;module=trunk"
FILES_${PN} += "${datadir} ${sysconfdir}"

pkg_postinst_callrec_append() {
	#!/bin/sh
	#still a bit buggy, if the state path change for instance
	files0="gsmhandset.state"
	files1="gsmheadset.state"
	files2="gsmspeakerout.state"
	state_dir=`sed -n "s/^scenario_dir\s*=\s*//p" /etc/frameworkd.conf`
	callrec_dir="/usr/share/callrec"
	
	for index in 0 1 2
	do
 		eval filename=\${files${index}}
		current_file=${state_dir}/${filename}
		patched="0"
		
		if [ -r ${callrec_dir}/${filename} ]; then
			echo "Backup of ${filename} already exists"
			echo "Replacing ${filename} with callrec-${filename}"
			cp ${callrec_dir}/callrec-${filename} ${current_file}
		else
			echo "Backing up ${filename}"
			cp ${current_file} ${callrec_dir}/
			
			#fix the patch
			sed -i "s!@STATE_PATH@!${current_file}!g" ${callrec_dir}/${filename}.patch
			echo "Patching ${filename}"
			patch -p0 < ${callrec_dir}/${filename}.patch && patched="1"
		fi
	
		if [ $patched -eq 0 ]; then
			echo "Failed patching ${filename}"
			echo "Replacing ${filename} with callrec-${filename}"
			echo "Backup is at ${callrec_dir}"
			cp ${callrec_dir}/callrec-${filename} ${current_file}
		fi
	done
}
pkg_prerm_callrec_append() {
	#!/bin/sh
	files0="gsmhandset.state"
	files1="gsmheadset.state"
	files2="gsmspeakerout.state"
	state_dir=`sed -n "s/^scenario_dir\s*=\s*//p" /etc/frameworkd.conf`
	
	for index in 0 1 2
	do
		eval filename=\${files${index}}
		current_file=${state_dir}/${filename}
		echo "Restoring ${filename} from backup"
		cp /usr/share/callrec/${filename} ${current_file}
		echo "Removing backups"
		rm /usr/share/callrec/${filename}
	done
}
