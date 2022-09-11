
public class Songs {
	String title;
	double duration;
	
	
	public Songs(String title, double duration) {
		this.title = title;
		this.duration = duration;
	}
	
	public String getTitle() {
		return title;
		
	}
	
	public double getDuration() {
		return duration;
	}
	
	@Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
	
}
