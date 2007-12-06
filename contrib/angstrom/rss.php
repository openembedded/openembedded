<? print('<?xml version="1.0" encoding="utf-8"?>');?>
<rss version="2.0" xml:base="http://www.anstrom-distribution.org/unstable/autobuild/" xmlns:dc="http://purl.org/dc/elements/1.1/">
<channel>
 <title>Ångstrom autobuilder updates </title>
 <link>http://www.anstrom-distribution.org/unstable/autobuild</link>
 <description></description>
 <language>en</language>
<?php

$base_path = "/home/angstrom/website/unstable/autobuild";

if ($handle = opendir("$base_path")) {

	while (false !== ($file = readdir($handle))) {
		if(is_dir($file) && $file != "." && $file != "..") {
			$second_handle = opendir("$base_path/$file/");
			while (false !== ($file2 = readdir($second_handle))) {
				if(is_file("/$base_path/$file/$file2")) { 
					$fmtime = filemtime("$file/$file2");

print("<item>\n");
print("<title>$file/$file2 uploaded</title>\n");
print(" <link>http://www.anstrom-distribution.org/unstable/autobuild/$file/$file2</link>\n");

$rsstime = strftime("%a, %d %b %Y %T +0000", $fmtime);

print("<pubDate>$rsstime</pubDate>\n");
print("<dc:creator>Angstrom autobuilder</dc:creator>");
print("</item>\n");

                                }
			}
			closedir($second_handle);
		}    

	}
	closedir($handle);
}
?>
</channel>
</rss>


