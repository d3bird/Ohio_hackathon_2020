package hackathon_2020;

import java.util.Vector;

public class search extends javax.swing.JFrame {

	/**
	 * Creates new form seach
	 */

	data_processing data_set;

	String[] search_results1;
	String[] search_results2;
	String[] search_results3;

	Vector<condensed_covid_data> data1;
	Vector<condensed_covid_data> data2;
	Vector<condensed_covid_data> data3;

	String[] sorts;

	public search(data_processing i) {
		data_set = i;
		search_results1 = new String[data_set.getCondensed_covid_data_points().size()];
		search_results2 = new String[data_set.getCondensed_covid_data_points().size()];
		search_results3 = new String[data_set.getCondensed_covid_data_points().size()];
		sorts = new String[5];
		sorts[0] = "Covid cases";
		//sorts[1] = "Ages affected";
		sorts[1] = "% Minorities";
		sorts[2] = "Health score";
		sorts[3] = "poverty percent";
		sorts[4] = "population of county";
		data1 = data_set.getCondensed_covid_data_points();
		data2 = data_set.getCondensed_covid_data_points();
		data3 = data_set.getCondensed_covid_data_points();
		sort(-1, -1);
		initComponents();
	}

	public void sort(int collum, int type) {

		if (type == -1 && collum == -1) {
			for (int i = 0; i < data1.size(); i++) {
				search_results1[i] = data1.get(i).county;
				search_results2[i] = data1.get(i).county;
				search_results3[i] = data1.get(i).county;
			}
			return;
		}

		if (type == 0) {
			System.out.println("covid sort");
			switch (collum) {
			case 0:
				data1.sort(new covid_case_com());
				break;
			case 1:
				data2.sort(new covid_case_com());
				break;
			case 3:
				data3.sort(new covid_case_com());
				break;
			}
		} else if (type == 1) {
			System.out.println("minorities sort");
			switch (collum) {
			case 0:
				data1.sort(new minorities_com());
				break;
			case 1:
				data2.sort(new minorities_com());
				break;
			case 3:
				data3.sort(new minorities_com());
				break;
			}
		} else if (type == 2) {
			System.out.println("health sort");
			switch (collum) {
			case 0:
				data1.sort(new health_com());
				break;
			case 1:
				data2.sort(new health_com());
				break;
			case 3:
				data3.sort(new health_com());
				break;
			}
		} /*
			 * else if (type == 3) { switch (collum) { case 0: data1.sort(new ()); break;
			 * case 1: data2.sort(new health_com()); break; case 3: data3.sort(new
			 * health_com()); break; } }
			 */
		else if (type == 4) {
			System.out.println("pop sort");
			switch (collum) {
			case 0:
				data1.sort(new population_com());
				break;
			case 1:
				data2.sort(new population_com());
				break;
			case 3:
				data3.sort(new population_com());
				break;
			}
		}

		for (int i = 0; i < data1.size(); i++) {
			if (collum == 0) {
				search_results1[i] = data1.get(i).county;
			} else if (collum == 1) {
				search_results2[i] = data1.get(i).county;
			} else {
				search_results3[i] = data1.get(i).county;
			}
		}

		// changes the lists
		if (collum == 0) {
			result_list.setModel(new javax.swing.AbstractListModel<String>() {
				String[] strings = search_results1;// { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

				public int getSize() {
					return strings.length;
				}

				public String getElementAt(int i) {
					return strings[i];
				}
			});
		} else if (collum == 1) {
			result_list1.setModel(new javax.swing.AbstractListModel<String>() {
				String[] strings = search_results2;// { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

				public int getSize() {
					return strings.length;
				}

				public String getElementAt(int i) {
					return strings[i];
				}
			});
		} else if (collum != -1) {
			result_list2.setModel(new javax.swing.AbstractListModel<String>() {
				String[] strings = search_results3;// { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

				public int getSize() {
					return strings.length;
				}

				public String getElementAt(int i) {
					return strings[i];
				}
			});
		}

	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel2 = new javax.swing.JLabel();
		case_count_num_1 = new javax.swing.JLabel();
		hosp_count_1 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		death_count_1 = new javax.swing.JLabel();
		parm1 = new javax.swing.JComboBox<>();
		parm2 = new javax.swing.JComboBox<>();
		parm3 = new javax.swing.JComboBox<>();
		jScrollPane1 = new javax.swing.JScrollPane();
		result_list = new javax.swing.JList<>();
		search = new javax.swing.JButton();
		covid = new javax.swing.JButton();
		age_groups = new javax.swing.JButton();
		groups = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		result_list1 = new javax.swing.JList<>();
		jScrollPane3 = new javax.swing.JScrollPane();
		result_list2 = new javax.swing.JList<>();
		covid1 = new javax.swing.JButton();
		groups1 = new javax.swing.JButton();
		age_groups1 = new javax.swing.JButton();
		covid2 = new javax.swing.JButton();
		groups2 = new javax.swing.JButton();
		age_groups2 = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		case_count_1 = new javax.swing.JLabel();
		hosp_count1 = new javax.swing.JLabel();
		death_count1 = new javax.swing.JLabel();
		health_score_1 = new javax.swing.JLabel();
		health_score_2 = new javax.swing.JLabel();
		health_score_l = new javax.swing.JLabel();
		jLabel17 = new javax.swing.JLabel();
		death_count2 = new javax.swing.JLabel();
		hosp_count2 = new javax.swing.JLabel();
		jLabel20 = new javax.swing.JLabel();
		jLabel21 = new javax.swing.JLabel();
		case_count_2 = new javax.swing.JLabel();
		health_score_3 = new javax.swing.JLabel();
		jLabel24 = new javax.swing.JLabel();
		jLabel25 = new javax.swing.JLabel();
		death_count3 = new javax.swing.JLabel();
		hosp_count3 = new javax.swing.JLabel();
		jLabel28 = new javax.swing.JLabel();
		jLabel29 = new javax.swing.JLabel();
		case_count_3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		poverty_per1 = new javax.swing.JLabel();
		jLabel31 = new javax.swing.JLabel();
		pop_count1 = new javax.swing.JLabel();
		jCheckBox1 = new javax.swing.JCheckBox();
		jCheckBox2 = new javax.swing.JCheckBox();
		jLabel33 = new javax.swing.JLabel();
		jLabel34 = new javax.swing.JLabel();
		jCheckBox3 = new javax.swing.JCheckBox();
		jLabel37 = new javax.swing.JLabel();
		jLabel38 = new javax.swing.JLabel();
		poverty_per2 = new javax.swing.JLabel();
		pop_count2 = new javax.swing.JLabel();
		poverty_per3 = new javax.swing.JLabel();
		pop_count3 = new javax.swing.JLabel();

		jLabel2.setText("case count");

		case_count_num_1.setText("0");

		hosp_count_1.setText("0");

		jLabel6.setText("Hospitalized Count");

		jLabel7.setText("death count");

		death_count_1.setText("0");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		parm1.setModel(new javax.swing.DefaultComboBoxModel<>(sorts));
		// new String[] { "Covid cases", "Ages affected", "% Minorities", "Health
		// score", "" }));
		parm1.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				parm1ItemStateChanged(evt);
			}
		});
		parm1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				parm1ActionPerformed(evt);
			}
		});

		parm2.setModel(new javax.swing.DefaultComboBoxModel<>(sorts));
		// new String[] { "Covid cases", "Ages affected", "% Minorities", "Health
		// score", "" }));
		parm2.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				parm2ItemStateChanged(evt);
			}
		});

		parm3.setModel(new javax.swing.DefaultComboBoxModel<>(sorts));
		// new String[] { "Covid cases", "Ages affected", "% Minorities", "Health
		// score", "" }));
		parm3.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				parm3ItemStateChanged(evt);
			}
		});

		result_list.setModel(new javax.swing.AbstractListModel<String>() {
			String[] strings = search_results1;// { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

			public int getSize() {
				return strings.length;
			}

			public String getElementAt(int i) {
				return strings[i];
			}
		});
		result_list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		result_list.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				result_listMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(result_list);

		search.setText("search");
		search.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				searchActionPerformed(evt);
			}
		});
		search.addKeyListener(new java.awt.event.KeyAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				searchMouseClicked(evt);
			}
		});

		covid.setText("Covid cases");
		covid.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				covidMouseClicked(evt);
			}
		});
		covid.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				covidActionPerformed(evt);
			}
		});

		age_groups.setText("age groups affected");
		age_groups.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				age_groupsMouseClicked(evt);
			}
		});

		groups.setText("groups affected");
		groups.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				groupsMouseClicked(evt);
			}
		});

		jLabel1.setText("Advanced search");

		result_list1.setModel(new javax.swing.AbstractListModel<String>() {
			String[] strings = search_results2;// { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

			public int getSize() {
				return strings.length;
			}

			public String getElementAt(int i) {
				return strings[i];
			}
		});
		result_list1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		result_list1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				result_list1MouseClicked(evt);
			}
		});
		jScrollPane2.setViewportView(result_list1);

		result_list2.setModel(new javax.swing.AbstractListModel<String>() {
			String[] strings = search_results3;// { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

			public int getSize() {
				return strings.length;
			}

			public String getElementAt(int i) {
				return strings[i];
			}
		});
		result_list2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		result_list2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				result_list2MouseClicked(evt);
			}
		});
		jScrollPane3.setViewportView(result_list2);

		covid1.setText("Covid cases");
		covid1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				covid1MouseClicked(evt);
			}
		});
		covid1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				covid1ActionPerformed(evt);
			}
		});

		groups1.setText("groups affected");
		groups1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				groups1MouseClicked(evt);
			}
		});

		age_groups1.setText("age groups affected");
		age_groups1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				age_groups1MouseClicked(evt);
			}
		});

		covid2.setText("Covid cases");
		covid2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				covid2MouseClicked(evt);
			}
		});
		covid2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				covid2ActionPerformed(evt);
			}
		});

		groups2.setText("groups affected");
		groups2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				groups2MouseClicked(evt);
			}
		});

		age_groups2.setText("age groups affected");
		age_groups2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				age_groups2MouseClicked(evt);
			}
		});

		jLabel3.setText("case count");

		jLabel8.setText("Hospitalized Count");

		jLabel9.setText("death count");

		jLabel10.setText("Health score");

		case_count_1.setText("0");

		hosp_count1.setText("0");

		death_count1.setText("0");

		health_score_1.setText("0");

		health_score_2.setText("0");

		health_score_l.setText("Health score");

		jLabel17.setText("death count");

		death_count2.setText("0");

		hosp_count2.setText("0");

		jLabel20.setText("Hospitalized Count");

		jLabel21.setText("case count");

		case_count_2.setText("0");

		health_score_3.setText("0");

		jLabel24.setText("Health score");

		jLabel25.setText("death count");

		death_count3.setText("0");

		hosp_count3.setText("0");

		jLabel28.setText("Hospitalized Count");

		jLabel29.setText("case count");

		case_count_3.setText("0");

		jLabel4.setText("poverty percent");

		poverty_per1.setText("0");

		jLabel31.setText("population");

		pop_count1.setText("0");

		jCheckBox1.setText("inverse results");
		jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox1ActionPerformed(evt);
			}
		});

		jCheckBox2.setText("inverse results");
		jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox2ActionPerformed(evt);
			}
		});

		jLabel33.setText("population");

		jLabel34.setText("poverty percent");

		jCheckBox3.setText("inverse results");
		jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox3ActionPerformed(evt);
			}
		});

		jLabel37.setText("population");

		jLabel38.setText("poverty percent");

		poverty_per2.setText("0");

		pop_count2.setText("0");

		poverty_per3.setText("0");

		pop_count3.setText("0");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(54, 54, 54))
						.addGroup(layout.createSequentialGroup().addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGroup(layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(age_groups, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(groups, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(layout.createSequentialGroup()
												.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
										.addComponent(covid, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(case_count_1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(hosp_count1, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(death_count1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(health_score_1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(poverty_per1,
																javax.swing.GroupLayout.DEFAULT_SIZE, 40,
																Short.MAX_VALUE))
												.addComponent(pop_count1, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(layout.createSequentialGroup()
										.addComponent(parm2, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE)))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup()
						.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(jCheckBox2, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(38, 38, 38))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(jLabel33, javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jLabel34, javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(health_score_l, javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(case_count_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(hosp_count2, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(death_count2, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(health_score_2, javax.swing.GroupLayout.PREFERRED_SIZE,
														40, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(poverty_per2, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(pop_count2, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
						.addGroup(layout.createSequentialGroup().addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(covid1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(groups1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(parm3, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 204,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(0, 0, Short.MAX_VALUE))
								.addComponent(age_groups1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(38, 38, 38)))
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addComponent(groups2, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
								.addComponent(covid2, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(age_groups2, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap())
						.addGroup(layout.createSequentialGroup()
								.addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 109,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addComponent(jCheckBox3, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGap(53, 53, 53))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												layout.createSequentialGroup().addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup().addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(jLabel28,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(jLabel29,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(jLabel25,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(jLabel24,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED))
														.addGroup(layout.createSequentialGroup()
																.addGroup(layout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(jLabel37,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				jLabel38,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))
																.addGap(3, 3, 3)))
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(pop_count3,
																		javax.swing.GroupLayout.Alignment.TRAILING,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 40,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(poverty_per3,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 40,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(case_count_3,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 40,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(hosp_count3,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 40,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(death_count3,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 40,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(health_score_3,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 40,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
														.addContainerGap())))
						.addGroup(layout.createSequentialGroup()
								.addComponent(parm1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE)))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(7, 7, 7)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(
										search, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(
										layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(
												groups1).addPreferredGap(
														javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(age_groups1))
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(parm1, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(parm3, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														parm2, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup()
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(jScrollPane2).addComponent(jScrollPane1)
																.addGroup(layout.createSequentialGroup().addGroup(layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																		.addGroup(layout.createSequentialGroup()
																				.addGroup(layout.createParallelGroup(
																						javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(jLabel21)
																						.addComponent(case_count_2))
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addGroup(layout.createParallelGroup(
																						javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(jLabel20)
																						.addComponent(hosp_count2))
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addGroup(layout.createParallelGroup(
																						javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(jLabel17)
																						.addComponent(death_count2))
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addGroup(layout.createParallelGroup(
																						javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(health_score_l)
																						.addComponent(health_score_2))
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addGroup(layout.createParallelGroup(
																						javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(jLabel34)
																						.addComponent(poverty_per2))
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addGroup(layout.createParallelGroup(
																						javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(jLabel33)
																						.addComponent(pop_count2))
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																				.addComponent(jCheckBox2))
																		.addGroup(layout
																				.createSequentialGroup().addGroup(layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(jLabel29)
																						.addComponent(case_count_3))
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addGroup(layout.createParallelGroup(
																						javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(jLabel28)
																						.addComponent(hosp_count3))
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addGroup(layout.createParallelGroup(
																						javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(jLabel25)
																						.addComponent(death_count3))
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addGroup(layout.createParallelGroup(
																						javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(jLabel24)
																						.addComponent(health_score_3))
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addGroup(layout.createParallelGroup(
																						javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(jLabel38)
																						.addComponent(poverty_per3))
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addGroup(layout.createParallelGroup(
																						javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(jLabel37)
																						.addComponent(pop_count3))
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																				.addComponent(jCheckBox3))
																		.addGroup(layout.createSequentialGroup()
																				.addGroup(layout.createParallelGroup(
																						javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(jLabel3)
																						.addComponent(case_count_1))
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addGroup(layout.createParallelGroup(
																						javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(jLabel8)
																						.addComponent(hosp_count1))
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addGroup(layout.createParallelGroup(
																						javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(jLabel9)
																						.addComponent(death_count1))
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addGroup(layout.createParallelGroup(
																						javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(jLabel10)
																						.addComponent(health_score_1))
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addGroup(layout.createParallelGroup(
																						javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(jLabel4)
																						.addComponent(poverty_per1))
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addGroup(layout.createParallelGroup(
																						javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(jLabel31)
																						.addComponent(pop_count1))
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																				.addComponent(jCheckBox1)))
																		.addGap(0, 31, Short.MAX_VALUE))))
												.addGroup(layout.createSequentialGroup().addGap(6, 6, 6)
														.addComponent(jScrollPane3)))
										.addGap(30, 30, 30)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(covid).addComponent(covid1))
												.addComponent(covid2, javax.swing.GroupLayout.Alignment.TRAILING))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
														.createSequentialGroup().addComponent(groups)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(age_groups))
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
														.createSequentialGroup().addComponent(groups2)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(age_groups2)))))
						.addContainerGap()));

		jCheckBox1.getAccessibleContext().setAccessibleName("inverse list");

		pack();
	}// </editor-fold>

	private void searchKeyPressed(java.awt.event.MouseEvent evt) {

	}

	private void searchMouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
	}

	private void covidActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void age_groupsMouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
	}

	private void groupsMouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
	}

	private void covidMouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
	}

	private void result_listMouseClicked(java.awt.event.MouseEvent evt) {
		// System.out.println(result_list.getSelectedIndex());
		int index = result_list.getSelectedIndex();
		case_count_1.setText(String.valueOf(data1.get(index).case_count));
		hosp_count1.setText(String.valueOf(data1.get(index).hospital_count));
		death_count1.setText(String.valueOf(data1.get(index).death_count));
		health_score_1.setText(String.valueOf(data1.get(index).info.health_score));
		// poverty_per1.setText(String.valueOf(data1.get(index).hospital_count));
		pop_count1.setText(String.valueOf(data1.get(index).info.population));
	}

	private void parm1ItemStateChanged(java.awt.event.ItemEvent evt) {
		// TODO add your handling code here:
	}

	private void parm2ItemStateChanged(java.awt.event.ItemEvent evt) {
		// TODO add your handling code here:
	}

	private void parm3ItemStateChanged(java.awt.event.ItemEvent evt) {
		// TODO add your handling code here:
	}

	private void result_list1MouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
	}

	private void result_list2MouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
	}

	private void covid1MouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
	}

	private void covid1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void groups1MouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
	}

	private void age_groups1MouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
	}

	private void covid2MouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
	}

	private void covid2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void groups2MouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
	}

	private void age_groups2MouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
	}

	private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void parm1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void searchActionPerformed(java.awt.event.ActionEvent evt) {
		// System.out.println("adsad");

		System.out.println(parm2.getSelectedIndex() + " " + parm3.getSelectedIndex() + " " + parm1.getSelectedIndex());
		sort(0, parm2.getSelectedIndex());
		sort(1, parm3.getSelectedIndex());
		sort(2, parm1.getSelectedIndex());
	}

	/**
	 * @param args the command line arguments
	 */

	// Variables declaration - do not modify
	private javax.swing.JButton age_groups;
	private javax.swing.JButton age_groups1;
	private javax.swing.JButton age_groups2;
	private javax.swing.JLabel case_count_1;
	private javax.swing.JLabel case_count_2;
	private javax.swing.JLabel case_count_3;
	private javax.swing.JLabel case_count_num_1;
	private javax.swing.JButton covid;
	private javax.swing.JButton covid1;
	private javax.swing.JButton covid2;
	private javax.swing.JLabel death_count1;
	private javax.swing.JLabel death_count2;
	private javax.swing.JLabel death_count3;
	private javax.swing.JLabel death_count_1;
	private javax.swing.JButton groups;
	private javax.swing.JButton groups1;
	private javax.swing.JButton groups2;
	private javax.swing.JLabel health_score_1;
	private javax.swing.JLabel health_score_2;
	private javax.swing.JLabel health_score_3;
	private javax.swing.JLabel health_score_l;
	private javax.swing.JLabel hosp_count1;
	private javax.swing.JLabel hosp_count2;
	private javax.swing.JLabel hosp_count3;
	private javax.swing.JLabel hosp_count_1;
	private javax.swing.JCheckBox jCheckBox1;
	private javax.swing.JCheckBox jCheckBox2;
	private javax.swing.JCheckBox jCheckBox3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel20;
	private javax.swing.JLabel jLabel21;
	private javax.swing.JLabel jLabel24;
	private javax.swing.JLabel jLabel25;
	private javax.swing.JLabel jLabel28;
	private javax.swing.JLabel jLabel29;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel31;
	private javax.swing.JLabel jLabel33;
	private javax.swing.JLabel jLabel34;
	private javax.swing.JLabel jLabel37;
	private javax.swing.JLabel jLabel38;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JComboBox<String> parm1;
	private javax.swing.JComboBox<String> parm2;
	private javax.swing.JComboBox<String> parm3;
	private javax.swing.JLabel pop_count1;
	private javax.swing.JLabel pop_count2;
	private javax.swing.JLabel pop_count3;
	private javax.swing.JLabel poverty_per1;
	private javax.swing.JLabel poverty_per2;
	private javax.swing.JLabel poverty_per3;
	private javax.swing.JList<String> result_list;
	private javax.swing.JList<String> result_list1;
	private javax.swing.JList<String> result_list2;
	private javax.swing.JButton search;
	// End of variables declaration
}