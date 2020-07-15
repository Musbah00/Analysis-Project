class FileManager{
	private ArrayList<String> lines;
	Scanner inputStream = null;
	PrintWriter outputStream = null;
	String filename;
	Scanner kb = new Scanner(System.in);
	public FileManager(String filename) {
		lines = new ArrayList<String>();
		this.filename = filename;
		try {
			inputStream = new Scanner(new FileInputStream(filename));
			while(inputStream.hasNextLine()) {
				lines.add(inputStream.nextLine());
			}
		}
		catch(FileNotFoundException f) {
			System.out.println(f);
		}
		inputStream.close();
		System.out.printf("Items have been loaded from %s\n", filename);
		for(int i=0;i<lines.size();i++) {
			System.out.println(lines.get(i));
		}
	}
	public void add() {
			int num;
			System.out.println("Please Enter the record in comma format (word,word,word,etc)");
			num = kb.nextInt();
			for(int i=0; i < num; i++) {
				System.out.println("Please enter the record in comma format (word,word,word,etc)");
				lines.add(kb.nextLine());
			}
		}
		public void update() {
			lines.clear();
			try {
				inputStream = new Scanner(new FileInputStream(filename));
				while(inputStream.hasNextLine()) {
					lines.add(inputStream.nextLine());
				}
			}
			catch(FileNotFoundException f) {
				System.out.println(f);
			}
			inputStream.close();
			System.out.println("Which Record would you like to update?");
			for(int i=0;i<lines.size();i++) {
				System.out.printf("%d %s\n", i,lines.get(i));
			}
			lines.remove(kb.nextInt());
			kb.nextLine();
			System.out.println("What would you like to change it too? (format: word,word,word,etc)");
			lines.add(kb.nextLine());
		}
	}
