# Moves all entries from /usr/lib/ipkg/alternatives to /usr/lib/opkg/alternatives
# If it exists in both it use file with more lines

pkg_postinst_${PN}_append () {
        alternatives_dir_old="${prefix}/lib/ipkg/alternatives"
        alternatives_dir_new="${prefix}/lib/opkg/alternatives"
	# if ${prefix}/lib/ipkg is already link (probably to ${prefix}/lib/opkg), then nothing needs to be merged and definitely we don't want "rm -rf ${alternatives_dir_old}" to happen
        if [ ! -h ${prefix}/lib/ipkg -a -e "${alternatives_dir_old}" ] ; then
                if [ ! -e "${alternatives_dir_new}" ] ; then
                        mkdir -p "${alternatives_dir_new}";
                fi
                echo "Old alternatives directory ${alternatives_dir_old} exists, moving entries to new one ${alternatives_dir_new}"
                echo "Creating backup copy of both ${alternatives_dir_old}-backup and ${alternatives_dir_new}-backup"
                cp -ra "${alternatives_dir_old}" "${alternatives_dir_old}-backup"
                cp -ra "${alternatives_dir_new}" "${alternatives_dir_new}-backup"

                cd ${alternatives_dir_old}
                for alt_file in * ; do
                        if [ ! -e "${alternatives_dir_new}/${alt_file}" ] ; then
                                echo "Moving old '${alternatives_dir_old}/${alt_file}' to '${alternatives_dir_new}/${alt_file}'";
                                mv -f "${alternatives_dir_old}/${alt_file}" "${alternatives_dir_new}/${alt_file}"
                        else
                                OLD_LINES=`wc -l ${alternatives_dir_old}/${alt_file} | cut -d/ -f 1`;
                                NEW_LINES=`wc -l ${alternatives_dir_new}/${alt_file} | cut -d/ -f 1`;
                                if [ $OLD_LINES -gt $NEW_LINES ] ; then
                                        echo "Replacing '${alternatives_dir_new}/${alt_file}' with '${alternatives_dir_old}/${alt_file}'";
                                        mv -f "${alternatives_dir_old}/${alt_file}" "${alternatives_dir_new}/${alt_file}"
                                elif [ $OLD_LINES -eq $NEW_LINES ] ; then
                                        if diff -q "${alternatives_dir_new}/${alt_file}" "${alternatives_dir_old}/${alt_file}" >/dev/null ; then
                                                echo "'${alternatives_dir_new}/${alt_file}' is the same"
                                        else
                                                echo "WARN: You have to update manually if needed. Please check: diff '${alternatives_dir_old}-backup/${alt_file}' '${alternatives_dir_new}-backup/${alt_file}'"
                                        fi
                                else
                                        echo "WARN: '${alternatives_dir_old}/${alt_file}' is shorter than new one, ignoring, but please check and update manually if needed"
                                fi
                        fi
                done
                rm -rf ${alternatives_dir_old}
                echo "Merge finished, old directory '${alternatives_dir_old}' is removed"
        fi
}
