#!/bin/sh
#
# CIA bot client script for BitKeeper repositories, delivering via email
#   -- Chris Larson <kergoth@handhelds.org>
#
# Based on ciabot_svn.sh by Micah Dowty <micah@picogui.org>
#
# See http://cia.navi.cx
# for more information on what the CIA bot is and how it works.
#
############# There are some parameters for this script that you can customize:

# Project information
project_name="openembedded"
return_address="oe@handhelds.org"

# System
sendmail_command="/usr/sbin/sendmail -t"

############# Below this line you shouldn't have to change anything

# Script arguments
REV="$1"

# The email address CIA lives at
cia_address="cia@navi.cx"

author=`echo $BK_USER | sed 's/\&/\&amp;/g;s/</\&lt;/g;s/>/\&gt;/g'`
module=`basename $BKD_ROOT | sed 's/\&/\&amp;/g;s/</\&lt;/g;s/>/\&gt;/g'`
log=`bk changes -r"$REV" -d":C:" | sed 's/\&/\&amp;/g;s/</\&lt;/g;s/>/\&gt;/g'`
tag=`bk changes -r"$REV" -d":TAG:" | sed 's/\&/\&amp;/g;s/</\&lt;/g;s/>/\&gt;/g'`
for file in `bk changes -n -v -r"$REV" -d"\\\$unless(:GFILE:=ChangeSet){:GFILE:}" | sort -u | sed 's/\&/\&amp;/g;s/</\&lt;/g;s/>/\&gt;/g'`; do
    files="$files<file>$file</file>"
done

# Send an email with the final XML message
(cat <<EOF
From: $return_address
To: $cia_address
Content-type: text/xml
Subject: DeliverXML

<message>
    <generator>
        <name>BitKeeper CIA Bot client shell script</name>
        <version>1.0</version>
    </generator>
    <source>
        <project>$project_name</project>
        <module>$module</module>
        <branch>$tag</branch>
    </source>
    <body>
        <commit>
            <revision>$REV</revision>
            <author>$author</author>
            <files>$files</files>
            <log>$log</log>
        </commit>
    </body>
</message>
EOF
) | tee ~/sendmailcmd.$$ | $sendmail_command

### The End ###
