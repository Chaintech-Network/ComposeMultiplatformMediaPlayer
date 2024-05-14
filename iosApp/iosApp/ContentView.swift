import SwiftUI
import shared

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        Platform_iosKt.MainViewController()
    }
    
    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}


struct ContentView: View {
    var body: some View {
        ComposeView()
           .background(Color(red: 0.059, green: 0.059, blue: 0.059))
           .ignoresSafeArea(.all)
//            .ignoresSafeArea(.keyboard, edges: .bottom)
//            .ignoresSafeArea(.keyboard)
    }
}
