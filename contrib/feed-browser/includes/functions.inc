<?php
/*
 * (c) Koen Kooi 2006, 2007, 2008
 * (c) Marcin Juszkiewicz 2006, 2007
 *
 * This program is free software; you can redistribute it and/or  modify it under
 * the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 2 of the License.
 * 
 * This program is distributed in the hope that it will be useful,  but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU Library General Public License along
 * with this library; see the file COPYING.LIB.  If not, write to the Free
 * Software Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307,
 * USA.
 *
 */

error_reporting(E_ALL);

function db_query($query)
{
    $result = FALSE;

    if($db_h = sqlite_open(DB_FILENAME))
    {
	$query_h = sqlite_query ($db_h, $query);
	$result = sqlite_fetch_all ($query_h, SQLITE_ASSOC);
	sqlite_close($db_h);
    }

    return $result;
}

function db_query_n($query)
{
    $result = FALSE;

    if($db_h = sqlite_open(DB_FILENAME))
    {
	$query_h = sqlite_query ($db_h, $query);
	sqlite_close($db_h);
    }

    return $result;
}

function db_table_exists ($db, $mytable)
{
	if($query = sqlite_query ($db, "SELECT name FROM sqlite_master WHERE type='table'"))
	{
		$tables = sqlite_fetch_all ($query, SQLITE_ASSOC);

		if (!$tables)
		{       
			return FALSE;
		}
		else
		{ 
			foreach ($tables as $table)
			{ 
				if ($table['name'] == $mytable)
				{
					return TRUE;  
				}
			}
		}
	}

	// function which is expected to return something need to return something always
	return FALSE;
}

function insert_feeds ($db) 
{
	global $feeds;

	if(isset($feeds))
	{
		$id = 1;

		foreach($feeds as $distro)
		{
			foreach($distro['feeds'] as $feed)
			{
				sqlite_query($db, "INSERT INTO feeds (f_id, f_name, f_uri, f_type) VALUES
					(
						{$id},
						'{$distro['distro_name']} {$distro['distro_version']} {$feed['name']}',
						'{$distro['feed_base_url']}{$feed['url']}',
						'{$feed['type']}'
					)");

				$id++;
			}
		}
	}
}

function searchletter($searchletter = '')
{
	$ipkgoutput = "<div id='letters'>";
	$alfabet = array('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y');

	foreach($alfabet as $letter)
	{
		if($letter == $searchletter)
		{
			$ipkgoutput .= sprintf(" %s |", $letter );
		}
		else
		{
			$ipkgoutput .= sprintf(" <a href='?letter=%s' title='packages which names begins with \"%s\"'>%s</a> |", $letter, $letter, $letter );
		}
	}

	$ipkgoutput .= " <a href='?letter=z' title='packages which names begins with \"z\"'>z</a></div>";

	return $ipkgoutput;
}

function searchpkg ($searchword, $searcharch = '')
{
	$query = "SELECT DISTINCT p_name,p_desc,p_section FROM packages WHERE p_name LIKE '$searchword' ";
	
	if(!empty($searcharch))
	{
		$query .= " AND p_arch='{$searcharch}' ";
	}

	$query .= 'ORDER BY p_name ASC';
	
	if($result = db_query($query))
	{
	    return generate_list_of_packages($result);
	}
}

function generate_list_of_packages($query_result)
{
	$ipkgoutput = "<table>\n";
	$ipkgoutput .="<tr><th>Package</th><th>Section</th><th>Description</th></tr>\n";

	foreach($query_result as $package)
	{
		if (!strstr ($package['p_name'], 'locale'))
		{
			if(strlen($package['p_desc']) > 40)
			{
				$pos = strpos($package['p_desc'],' ',  40);

				if($pos)
				{
					$package['p_desc'] = substr($package['p_desc'], 0, $pos) . '...';
				}
			}

			$ipkgoutput .= sprintf
				("<tr><td><a href='?pkgname=%s'>%s</a></td><td><a href=\"?section=%s\">%s</a></td><td> %s</td></tr>\n",
				urlencode($package['p_name']), $package['p_name'], $package['p_section'], $package['p_section'], htmlentities($package['p_desc']));
		}

	}
	
	$ipkgoutput .= '</table>';

	return $ipkgoutput;
}

function searchsection($section)
{
	if($result = db_query("SELECT DISTINCT p_name,p_desc,p_section FROM packages WHERE p_section LIKE '$section%' ORDER BY p_section ASC, p_name ASC"))
	{	
	    return generate_list_of_packages($result);
	}
}

function pkgdetails ($package)
{
	$result = db_query("SELECT * FROM packages,feeds
				WHERE (packages.p_name='$package' OR packages.p_provides='$package')
				    AND feeds.f_id = packages.p_feed 
				ORDER BY packages.p_version DESC, packages.p_arch ASC ");
	
	// display first result

	if ($result)
	{
		$package = $result[0];

		$details = sprintf("<h1>Package details for %s %s</h1>", $package['packages.p_name'], $package['packages.p_version']);
		$details .= sprintf ("<p id='description'>%s</p>", htmlentities($package['packages.p_desc']));
		$details .= "<dl>";

		$details .= sprintf ("\n<dt>Maintainer:</dt><dd>%s</dd>", str_replace(array('@',', '), array(' at ', '<br />'), htmlentities($package['packages.p_maintainer'])));

		$scapfile = "img/packages/".$package['packages.p_name'][0]."/".$package['packages.p_name'].".png";
		if(file_exists(FB_BASE_DIR.$scapfile))
		{
			$details .= sprintf ("\n<dt>Screenshot:</dt><dd><a href='%s'><img src='%s' width='320px' noborder></a></dd>", $scapfile, $scapfile);
		}

		if($package['packages.p_homepage']) 
		{
			$details .= sprintf ("\n<dt>Homepage:</dt><dd>%s</dd>", $package['packages.p_homepage']);
		}

		if($package['packages.p_section'])
		{
			$details .= sprintf ("\n<dt>Section:</dt><dd><a href='?section=%s'>%s</a></dd>", $package['packages.p_section'],$package['packages.p_section']);
		}
		
		if($package['packages.p_depends'])
		{
			$details .= sprintf ("\n<dt>Depends:</dt><dd>%s</dd>", addlinks ($package['packages.p_depends']));
		}
		
		if($package['packages.p_recommends'])
		{
			$details .= sprintf ("\n<dt>Recommends:</dt><dd>%s</dd>", addlinks ($package['packages.p_recommends']));
		}
		
		if($package['packages.p_replaces'])
		{
			$details .= sprintf ("\n<dt>Replaces:</dt><dd>%s</dd>", addlinks ($package['packages.p_replaces']));
		}
		
		if($package['packages.p_provides'])
		{
			$details .= sprintf ("\n<dt>Provides:</dt><dd>%s</dd>", addlinks ($package['packages.p_provides']));
		}
		
		if($package['packages.p_conflicts'])
		{
			$details .= sprintf ("\n<dt>Conflicts:</dt><dd>%s</dd>", addlinks ($package['packages.p_conflicts']));
		}
		
		$size = $package['packages.p_size'];

		if(strlen($size) > 6) 
		{
			$size = sprintf("%02.2f Megabytes", $size / (1024 * 1024));
		}

		if(strlen($size) > 3 && strlen($size) < 7) 
		{
			$size = sprintf("%02.2f Kilobytes", $size / (1024 ));
		}

		if(strlen($size) < 4) 
		{
			$size = sprintf("%s Bytes", $size);
		}

		$details .= sprintf ("\n<dt>Size:</dt><dd>%s</dd></dl>", $size);

		if($package['packages.p_source'])
		{
			$sourcearray = explode (" ", $package['packages.p_source']);

			$details .= "\n<h2>Source:</h2><ul>";

			foreach ($sourcearray as $key => $source_url)
			{
				if (substr ($source_url, 0, 4) == "http" || substr ($source_url, 0, 3) == "ftp")
				{
					$url_parts = parse_url($source_url);

					$details .= sprintf ("<li><a href='%s'>%s</a></li>", $source_url, array_pop(explode('/', $url_parts['path'])));
				}
				else
				{
					$details .= sprintf ("<li>%s</li>", $source_url);
				}
			}

			$details .= '</ul>';

		}

		$details .= "\n<h2>Available versions and architectures:</h2><ul id='download'>\n";

		foreach($result as $packages_a)
		{
			$details .= sprintf("\n<li><a class='download' href='%s' title='%s %s for %s'>%s %s</a> for %s (%s feed)</li>\n",
				$packages_a['feeds.f_uri']."/".$packages_a['packages.p_file'],
				$packages_a['packages.p_name'],
				$packages_a['packages.p_version'],
				$packages_a['packages.p_arch'],
				$packages_a['packages.p_name'],
				$packages_a['packages.p_version'],
				$packages_a['packages.p_arch'],
				$packages_a['feeds.f_name']
			);
		}

		$details .= "</ul>\n";
	}
	else
	{
		$details = "<h1>Sorry, package not found\n</h1><a href='./'>return</a>\n";
	}

	return $details;
}

function addlinks ($input)
{
	// split input elements up
	$elements = explode (', ', $input);

	$offset = 0;

	foreach ($elements as $element)
	{
		// strip version number
		$element = ereg_replace('^(.*)( \((.*)\))+$', '\\1', $element);

		// do we have this package in the db?
		$result =  db_query ("SELECT DISTINCT p_name FROM packages WHERE p_name='{$element}' OR p_provides='{$element}'");    

		if(isset($result[0]['p_name']))
		{
			// find position of string in line
			$pos = strpos ($input, $element, $offset);
			$link = sprintf("<a href=\"?pkgname=%s\">$element</a>", urlencode ($element));

			// replace element with a link
			$input = substr_replace ($input, $link, $pos, strlen ($element));

			// update offset
			$offset = ($pos + strlen ($link));
		}
		else
		{
			$offset += strlen ($element);
		}
	}

	return $input;
} 

function sectionslist()
{
	$ipkgoutput = '';

	if($result =  db_query ("SELECT DISTINCT p_section FROM packages ORDER BY p_section"))
	{
		$section_up = '';

		$sections = array();

		foreach($result as $package)
		{
			$section_split = explode('/', $package['p_section']);

			if($section_up != $section_split[0])
			{
				$section_up = $section_split[0];
			}

			if(isset($section_split[1]))	// x11/gnome/libs
			{
				$sections[$section_up][$section_split[1]] = $section_split[1];

				if(isset($section_split[2]))	// x11/gnome/libs
				{
					$sections[ $section_up ][ $section_split[1] ] = array($section_split[2]=>$section_split[2]);
				}
			}
		}

		$output = "<ul id='sections'>\n";

		foreach($sections as $section_name1=>$item)
		{
			$output .= sprintf ("<li><a href='?section=%s' title='%s'>%s</a>",
				urlencode($section_name1),
				urlencode($section_name1),
				$section_name1);

			if(is_array($item))
			{
				$output .= '<ul class="subsections">';

				foreach($item as $section_name2=>$subitem)
				{
					$section_name = "{$section_name1}/{$section_name2}";
					$output .= sprintf ("<li><a href='?section=%s' title='%s'>%s</a>",
						urlencode($section_name),
						urlencode($section_name),
						$section_name2);

					if(is_array($subitem))
					{
						$output .= '<ul class="subsections">';

						foreach($subitem as $section_name3=>$subitem2)
						{
							$section_name = "{$section_name1}/{$section_name2}/{$section_name3}";
							$output .= sprintf ("<li><a href='?section=%s' title='%s'>%s</a></li>",
								urlencode($section_name),
								urlencode($section_name),
								$section_name3);
						}

						$output .= '</ul>';
					}

					$output .= '</li>';
				}

				$output .= '</ul>';
			}

			$output .= '</li>';
		}

		$output .= "</ul>\n";
	}

	return $output;
}

function check_database()
{
	$db_exists = FALSE;

	if($db = sqlite_open(DB_FILENAME))
	{
		$db_exists = TRUE;

		//initialize db
		if (db_table_exists ($db, 'packages') === FALSE)
		{  
			sqlite_query ($db, "CREATE TABLE  packages (
				p_name         varchar(50),
				p_version    varchar(10),
				p_arch        varchar(12),
				p_depends    varchar(50),
				p_maintainer    varchar(50),
				p_homepage    varchar(100),
				p_section    varchar(20),
				p_replaces    varchar(50),
				p_provides    varchar(50),
				p_recommends varchar(50),
				p_conflicts    varchar(50),
				p_size        int(10),
				p_md5        char(32),
				p_source    varchar(500),
				p_feed        varchar(20),
				p_file        varchar(100),
				p_desc        varchar(1000))");
		}

		if (db_table_exists ($db, 'feeds') === FALSE)
		{  
			sqlite_query ($db, "CREATE TABLE feeds (
				f_id         int(8),
				f_name       varchar(32),
				f_uri        varchar(100),
				f_type		 varchar(16),
				f_comments   varchar(500))");

			insert_feeds ($db) ;
		}

		sqlite_close($db);
	}

	return $db_exists;
}

function read_vars_from_get($array_of_vars)
{
    foreach($array_of_vars as $name_of_var)
    {
	$GLOBALS[$name_of_var] = '';

	if(isset($_GET[$name_of_var]))
	{
	    $GLOBALS[$name_of_var] = $_GET[$name_of_var];
	}
    }
}

function get_arch_list()
{
    return db_query('SELECT DISTINCT p_arch FROM packages WHERE p_arch NOT IN (NULL, "", "all") ORDER BY p_arch ASC');
}
?>
